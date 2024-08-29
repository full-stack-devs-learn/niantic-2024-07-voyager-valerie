/*
1.	Pizza Shack sells the best pizza in town.

	When customers are ready to order, they should
	be able to see a list of toppings that are 
	included on each type of pizza.

	getToppings("Hawaiian") => ["Ham","Pineapple","Mushroom"]
	getToppings("Cowboy") => ["Pepperoni", "Sausage", "Beef"]
	getToppings("Supreme") => ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"]
	getToppings("Vegetarian") => ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"]
	getToppings("Cheese") => ["Cheese"]

*/
function getToppings(pizza)
{
	const pizzaRecipes = {
		"Hawaiian": ["Ham","Pineapple","Mushroom"],
		"Cowboy": ["Pepperoni", "Sausage", "Beef"],
		"Supreme": ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"],
		"Vegetarian": ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"],
		"Cheese": ["Cheese"]
	}

	function toTitleCase(str){
		return str
			.toLowerCase()
			.split(' ')
			.map(word => word.charAt(0).toUpperCase() + word.slice(1))
			.join(' ');
	}

	const standardizedPizzaName = toTitleCase(pizza);	

	// if pizza exists, return toppings. else, return empty array
	return pizzaRecipes[standardizedPizzaName] || [];

	
}



/*
2.	Pizza Shack sells the best pizza in town.

	When a customer places an order we make the pizza.
	the makePizza function should return a 
	pizza object with a name, and the list of toppings.

	makePizza("Hawaiian") => {
								name: "Hawaiian",
								toppings: ["Ham","Pineapple","Mushroom"]
							}

*/

function makePizza(pizza)
{
	const pizzaRecipes = {
		"Hawaiian": ["Ham","Pineapple","Mushroom"],
		"Cowboy": ["Pepperoni", "Sausage", "Beef"],
		"Supreme": ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"],
		"Vegetarian": ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"],
		"Cheese": ["Cheese"]
	}

	if (!(pizza in pizzaRecipes)) {
		return {};
	}

	const toppings = getToppings(pizza);
	const pizzaMade = {
						name: pizza,
						toppings: toppings
	}

		return pizzaMade;

}


/*
3.	Pizza Shack sells the best custom pizza in town.

	If a customer wants to order a custom pizza they
	can order up to 3 toppings. The makeCustom function
	should create the new pizza as follows...

	makeCustom("chicken") => 
					{
						name: "Custom",
						toppings: ["chicken"]
					}

	makeCustom("chicken", "mushroom") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom"]
					}

	makeCustom("chicken", "mushroom", "artichokes") => 
					{
						name: "Custom",
						toppings: ["chicken", "mushroom", "artichokes"]
					}

	// a custom order with no toppings is not allowed an should return
	// an empty object
	makeCustom() => {}

*/

function makeCustom(...toppings){

	if (toppings.length === 0) {
		return {};
	}

	return {
		name: "Custom",
		toppings: toppings
	};
}


/*
4.	Customers may want to order multiple pizzas on a single order.

	When a customer places an order you should create an order object.
	This includes the customer name, and an array of all the pizzas
	that they have ordered.

	createOrder("Gary", true, false, false, false, false) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				}
			]
		}
	

	createOrder("Gary", true, false, false, false, true) => 
		{
			customer: "Gary",
			pizzas: [
				{
					name: "Hawaiian",
					toppings: [
						"Ham",
						"Pineapple",
						"Mushroom"
					]
				},
				{
					name: "Cheese",
					toppings: [
						"Cheese"
					]
				}
			]
		}


*/

function createOrder(name, Hawaiian, Cowboy, Supreme, Vegetarian, Cheese){

	const pizzaRecipes = {
		"Hawaiian": ["Ham", "Pineapple", "Mushroom"],
		"Cowboy": ["Pepperoni", "Sausage", "Beef"],
		"Supreme": ["Pepperoni", "Sausage", "Pepper", "Onion", "Black Olives"],
		"Vegetarian": ["Spinach", "Zucchini", "Mushroom", "Artichoke", "Tomato", "Onion"],
		"Cheese": ["Cheese"]
	};

	const orderedPizzas = [];

	if (Hawaiian) {
		orderedPizzas.push({
			name: "Hawaiian",
			toppings: pizzaRecipes["Hawaiian"]
		});
	}

	if (Cowboy) {
		orderedPizzas.push({
			name: "Cowboy",
			toppings: pizzaRecipes["Cowboy"]
		});
	}

	if (Supreme) {
		orderedPizzas.push({
			name: "Supreme",
			toppings: pizzaRecipes["Supreme"]
		});
	}

	if (Vegetarian){
		orderedPizzas.push({
			name: "Vegetarian",
			toppings: pizzaRecipes["Vegetarian"]
		});
	}

	if (Cheese) {
		orderedPizzas.push({
			name: "Cheese",
			toppings: pizzaRecipes["Cheese"]
		});
	}

	if (orderedPizzas.length === 0){
		return {};
	}

	return {
		customer: name,
		pizzas: orderedPizzas
	};
}
