let service;

let itemInput;
let itemError;
let quantityInput;
let quantityError;

let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list");
    parent.innerHTML = "";

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addNewItem(event)
{
    event.preventDefault();

    if(itemInput && quantityInput)
    {
        showErrors();

        if (itemInput.validity.valid && quantityInput.validity.valid && quantityInput.value >= 1)
        {
            const itemName = document.getElementById("itemName").value;
            const quantity = document.getElementById("quantity").value;

            const newItem = {
                id: list.length + 1,
                title: itemName,
                quantity: quantity,
                isComplete: false
            }

            list.push(newItem);
            displayShoppingList();

            clearForm();
        }
    }
}

function clearForm()
{
    document.getElementById("itemName").value = "";
    document.getElementById("quantity").value = "";
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    div.addEventListener('click', () => {
        item.isComplete = true;
        div.classList.add("complete");
    })
    div.addEventListener('dblclick', () => {
        item.isComplete = false;
        div.classList.remove("complete");
    })

    addItemTitle(item, div);
    addQuantity(item, div)

    parent.appendChild(div)
}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}

function markAllItemsComplete() {
    list.forEach(item => {
        if (!item.isComplete) {
            item.isComplete = true;
        }
    });
    allItemsIncomplete = false;
    updateButtonText();
    displayShoppingList();
}

function markAllItemsIncomplete() {
    list.forEach(item => {
        if (item.isComplete) {
            item.isComplete = false;
        }
    });
    allItemsIncomplete = true;
    updateButtonText();
    displayShoppingList();
}

function updateButtonText() {
    const allCompleteButton = document.getElementById("allCompleteButton");
    if (allItemsIncomplete) {
        allCompleteButton.textContent = "Mark All Completed";
    } else {
        allCompleteButton.textContent = "Mark All Incomplete";
    }
}

function setUpValidation()
{
    itemInput = document.getElementById("itemName");
    itemError = document.getElementById("itemError");
    quantityInput = document.getElementById("quantity");
    quantityError = document.getElementById("quantityError");
}

function showErrors()
{
    if(!itemInput.validity.valid)
    {
        itemError.textContent = "Item name must be inputted";
        itemInput.classList.add("error")
    }
    else
    {
        itemError.textContent = "";
        itemInput.classList.remove("error")
    }

    if(!quantityInput.validity.valid || quantityInput.value <= 0)
    {
        quantityError.textContent = "Item quantity is required and must be a positive number";
        quantityInput.classList.add("error")
    }
    else
    {
        quantityError.textContent = "";
        quantityInput.classList.remove("error")
    }
}

// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();

    const allComplete = document.getElementById("allCompleteButton");
    if (allComplete)
    {
        allComplete.addEventListener('click', () => {
            if(allItemsIncomplete) 
            {
                markAllItemsComplete();
            }
            else 
            {
                markAllItemsIncomplete();
            }
        });
    }    

    const form = document.querySelector("form");
    if(form)
    {    
        form.addEventListener("submit", addNewItem);
    }

    setUpValidation();
});

