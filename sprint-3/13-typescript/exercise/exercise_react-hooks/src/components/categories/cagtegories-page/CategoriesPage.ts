"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = CategoriesPage;
const react_1 = require("react");
const CategoryAdd_1 = __importDefault(require("../category-add/CategoryAdd"));
const CategoryCardContainer_1 = __importDefault(require("../category-card-container/CategoryCardContainer"));
require("./CategoriesPage.css");
function CategoriesPage() {
    const [action, setAction] = (0, react_1.useState)("list");
    return (<div className='container'>
            <header className="mt-4">
                <h1>Categories</h1>
            </header>
            <button className="btn btn-danger" onClick={() => setAction("add")}>Add Category</button>

            {action === "list" && <CategoryCardContainer_1.default></CategoryCardContainer_1.default>}
            {action === "add" && <CategoryAdd_1.default onCancel={() => setAction("list")} onCategoryAdded={() => setAction("list")}></CategoryAdd_1.default>}
            
        </div>);
}
