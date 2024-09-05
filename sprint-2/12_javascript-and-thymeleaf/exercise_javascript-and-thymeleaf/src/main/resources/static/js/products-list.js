
// accessing the categories and products data
document.addEventListener('DOMContentLoaded', () => {
    const categorySelection = document.getElementById('category');
    const productsTable = document.getElementById('products-table');

    // update displayed rows based on user-selected category id
    const loadProducts = (categoryId) => {
        if (categoryId) {
            const url = `/products/table?catId=${categoryId}`; // where the data is accessed

            fetch(url)
                .then(response => {
                    if (response.ok) {
                        return response.text();
                    }
                    throw new Error(`Error! Status: ${response.status}`);
                })
                .then(html => {
                    productsTable.innerHTML = html; // if valid category id, display all products in that category
                })
                .catch(error => {
                    console.log('Fetch error: ', error);
                });
        }
    };

    // changing products displayed by category via dropdown menu
    categorySelection.addEventListener('change', () => {
        const categoryId = categorySelection.value;
        loadProducts(categoryId);
    });

    // load products for initial category (but not part of project parameters)
//    const initialCategoryId = categorySelection.value;
//    if (initialCategoryId) {
//        loadProducts(initialCategoryId);
//    }
});




