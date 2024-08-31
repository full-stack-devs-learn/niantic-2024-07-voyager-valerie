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
                            .sort((left, right) => left.isComplete - right.isComplete)
                            .map(grocery => {
                                return {
                                    ...grocery,
                                    priorityText: grocery.isComplete == false
                                                        ? "pending"
                                                        : "complete"
                                }
                            })

    const groceryListContainer = document.getElementById("shopping-list");

    groceries.forEach(grocery => {
        createShoppingDiv(grocery, groceryListContainer);
    })
}

function createShoppingDiv(grocery, parent){
    const shoppingDiv = document.createElement("div");

    shoppingDiv.classList.add("list-item");

    if(grocery.isComplete)
    {
        shoppingDiv.classList.add("complete");
    }

    parent.appendChild(shoppingDiv);

    buildItemName(grocery, shoppingDiv);    
    buildItemQuantity(grocery, shoppingDiv);
}


function buildItemName(grocery, parent){
    const nameDiv = document.createElement("div");
    nameDiv.classList.add("title");
    nameDiv.textContent = grocery.title;

    parent.appendChild(nameDiv);
}

function buildItemQuantity(grocery, parent){
    const quantityDiv = document.createElement("div");
    quantityDiv.classList.add("quantity");
    quantityDiv.textContent = grocery.quantity;

    parent.appendChild(quantityDiv);
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



