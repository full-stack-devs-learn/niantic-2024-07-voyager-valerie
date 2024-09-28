"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = CategoryCardContainer;
const react_1 = require("react");
const CategoryCard_1 = __importDefault(require("../category-card/CategoryCard"));
require("./CategoryCardContainer.css");
const category_service_1 = __importDefault(require("../../../services/category-service"));
const ProductsList_1 = __importDefault(require("../../products/products-list/ProductsList"));
// import { categories } from '../../../data'
function CategoryCardContainer() {
    const [selectedCategory, setSelectedCategory] = (0, react_1.useState)("None Selected");
    const [selectedCategoryId, setSelectedCategoryId] = (0, react_1.useState)(0);
    const [categories, setCategories] = (0, react_1.useState)([]);
    (0, react_1.useEffect)(() => {
        category_service_1.default.getAllCategories().then(data => {
            console.log("data being returned:");
            console.log(data);
            setCategories(data);
        });
    }, 
    // an emptry array says that I only want
    // this code to run one time before the first render
    []);
    const categorySelected = (name) => {
        setSelectedCategory(name);
        const categoryId = categories.filter(cat => cat.categoryName === name)[0].categoryId;
        setSelectedCategoryId(categoryId);
        console.log(name);
    };
    const categoryDeleted = (categoryId) => {
        const newList = categories.filter(category => category.categoryId !== categoryId);
        setCategories(newList);
    };
    return (<>
        <h5 className="container">Selected Category: {selectedCategory}</h5>
        <main className="container mt-4 categories-container" id="categories-container">
        {categories.map((category) => (<CategoryCard_1.default key={category.categoryId} category={category.categoryName} id={category.categoryId} onCategorySelected={categorySelected} onCategoryDeleted={categoryDeleted}></CategoryCard_1.default>))}
        </main>
        <ProductsList_1.default categoryId={selectedCategoryId}></ProductsList_1.default>
        </>);
}
