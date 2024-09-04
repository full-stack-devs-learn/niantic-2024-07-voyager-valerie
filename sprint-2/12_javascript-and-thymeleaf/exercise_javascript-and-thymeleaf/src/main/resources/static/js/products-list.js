document.addEventListener('DOMContentLoaded', () => {
    const categorySelection = document.getElementById('category');

    categorySelection.addEventListener('change', () => {
        const categoryId = categorySelection.value;
        const url = `/products/categories/${categoryId}`;

        fetch(url)
            .then(response => {
                if(response.status === 200)
                {
                    return response.text();
                }
                throw new Error('Error! Status: ${response.status}');
            })
            .then(html => {
                const productsTable = document.getElementById('products-table');
                productsTable.innerHTML = html;
            })
            .catch(error => {
                console.log('Fetch error: ', error);
            });
        }
        else
        {
            const productsTable = document.getElementById('products-table');
            productsTable.innerHTML = "";
        }
    });
});

function loadPage()
{
    const container = document.getElementById('products-container');
    container.innerHTML = "";

}

