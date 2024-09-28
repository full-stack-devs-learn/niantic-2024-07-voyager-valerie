"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = ProductsPage;
require("./ProductsPage.css");
const ProductCardContainer_1 = __importDefault(require("../product-card-container/ProductCardContainer"));
const react_1 = require("react");
function ProductsPage() {
    const [action, setAction] = (0, react_1.useState)("list");
    return (<>
        <div className="container">
            <header className="mt-4">
                <h1>Products</h1>
            </header>

            <button className="btn btn-danger" onClick={() => setAction("add")}>Add Product</button>

            {action === "list" && <ProductCardContainer_1.default></ProductCardContainer_1.default>}
            {/* {action === "add" && <ProductAdd on} */}
        </div>

        </>);
}
