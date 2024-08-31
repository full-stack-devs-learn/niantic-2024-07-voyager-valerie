// add pageTitle

// add groceries

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
const service = new ShoppingService();

function displayListTitle() {
    const listTitle = document.getElementById("title");
    listTitle.textContent = service.getListName();
}
    
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
    const groceries = service.getShoppingList()

    const groceryListContainer = document.getElementById("container");

    groceries.forEach(grocery => {
        createShoppingDiv(grocery, groceryListContainer);
    })
}

function createShoppingDiv(grocery, parent){
    const shoppingDiv = document.createElement("div");

    shoppingDiv.classList.add("grocery");

    parent.appendChild(shoppingDiv);
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
}

document.addEventListener("DOMContentLoaded", () => {
    
    displayListTitle();
    displayGroceries();
});



