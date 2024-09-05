document.addEventListener('DOMContentLoaded', () => {
    const addedProduct = document.querySelector('form');

    addedProduct.addEventListener('submit', (event) => {
        let isValid = true;

        const productName = document.getElementById('productName');
        const categoryId = document.getElementById('categoryId');
        const quantityPerUnit = document.getElementById('quantityPerUnit');
        const unitPrice = document.getElementById('unitPrice');
        const unitsInStock = document.getElementById('unitsInStock');
        const unitsOnOrder = document.getElementById('unitsOnOrder');
        const reOrderLevel = document.getElementById('reOrderLevel');

        document.querySelectorAll('.invalid-feedback').forEach(invalid => invalid.textContent = '');

        if (!productName.value.trim()) {
            isValid = false;
            productName.nextElementSibling.textContent = 'Product name is required and must be between 3 and 50 characters.';
        }

        if (!categoryId.value) {
            isValid = false;
            categoryId.nextElementSibling.textContent = 'Category selection is required.';
        }

        if (!quantityPerUnit.value.trim()) {
            isValid = false;
            quantityPerUnit.nextElementSibling.textContent = 'Quantity per unit is required.';
        }

        const unitPriceInput = parseFloat(unitPrice.value);
        if (isNaN(unitPriceInput) || unitPriceInput <= 0) {
            isValid = false;
            unitPrice.nextElementSibling.textContent = 'Unit price is required and must be a positive number.';
        }

        const unitsInStockInput = parseInt(unitsInStock.value, 10);
        if (isNaN(unitsInStockInput) || unitsInStockInput < 0) {
            isValid = false;
            unitsInStock.nextElementSibling.textContent = 'Units in stock is required and cannot be negative, and must be at least 0.';
        }

        const unitsOnOrderInput = parseInt(unitsOnOrder.value, 10);
        if (isNaN(unitsOnOrderInput) || unitsOnOrderInput < 0) {
            isValid = false;
            unitsOnOrder.nextElementSibling.textContent = 'Units on order cannot be negative, and must be at least 0.';
        }

        const reOrderLevelInput = parseInt(reOrderLevel.value, 10);
        if (isNaN(reOrderLevelInput) || reOrderLevelInput < 0) {
            isValid = false;
            reOrderLevel.nextElementSibling.textContent = 'Reorder level must be at least 0.';
        }

        if (!isValid) {
            event.preventDefault(); // don't allow form to submit with errors
        }
    });
});


