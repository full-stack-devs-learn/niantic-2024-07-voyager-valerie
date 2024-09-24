document.addEventListener('DOMContentLoaded', () => {
    const berryInfoContainer = document.getElementById('berry-info');
    const berryImage = document.getElementById('berry-image');
    const berryButtonsContainer = document.getElementById('berry-buttons');
    const instructions = document.getElementById('instructions');

    const loadAllBerries = () => {
        berryButtonsContainer.innerHTML='';
    
        const apiUrl = 'https://pokeapi.co/api/v2/berry/';
        axios.get(apiUrl)
            .then(response => {
                const berries = response.data.results;
                berries.forEach(berry => {
                    const button = document.createElement('button');
                    button.classList.add('berry-btn');
                    button.textContent = berry.name;
                    button.setAttribute('data-berry-url', berry.url);
                    berryButtonsContainer.appendChild(button);

                    // loads berry data upon click
                    button.addEventListener('click', () => {
                        const berryUrl = button.getAttribute('data-berry-url');
                        loadBerryData(berryUrl, berry.name);
                    });
                });
            })
            .catch(error => console.error('Error fetching berries:', error));
    };

    const checkImage = (imageUrl) => {
        return new Promise((resolve, reject) => {
            const img = new Image();
            img.src = imageUrl;
            img.onload = () => resolve(imageUrl); // resolve if the image loads
            img.onerror = () => reject(); // reject if it fails to load
        });
    };

    const loadBerryData = (berryUrl, berryName) => {
        axios.get(berryUrl)
            .then(response => {
                const data = response.data;

                instructions.style.display = 'none';

                const berryName = data.name;
                const imagePaths = [
                    `/app/images/${berryName}.png`,
                    `/app/images/${berryName}.jpeg`,
                    `/app/images/${berryName}.webp`
                ];
    
                const loadImage = (index) => {
                    if (index >= imagePaths.length) {
                        console.error(`No image found for ${berryName}.`);
                        //berryImage.classList.add('hidden'); // hide image if not found
                        return; // exit if all types failed
                    }
                    
                    console.log(`Checking image: ${imagePaths[index]}`); // Log current image being checked
                
                    checkImage(imagePaths[index])
                        .then((src) => {
                            console.log(`Image found: ${src}`); // log found image source
                            berryImage.src = src; // load the found image
                            //berryImage.classList.remove('hidden'); // Show the image
                        })
                        .catch(() => {
                            loadImage(index + 1); // try the next image type
                        });

                };
                loadImage(0);
                

                berryInfoContainer.innerHTML = `
                    <h2>${data.name}</h2>
                    <p><strong>Growth Time:</strong> ${data.growth_time} hours</p>
                    <p><strong>Max Harvest:</strong> ${data.max_harvest}</p>
                    <p><strong>Size:</strong> ${data.size} mm</p>
                    <p><strong>Smoothness:</strong> ${data.smoothness}</p>
                    <p><strong>Soil Dryness:</strong> ${data.soil_dryness}</p>
                `;
            })
            .catch(error => console.error('Error fetching berry details:', error));
    };

    loadAllBerries();
});
