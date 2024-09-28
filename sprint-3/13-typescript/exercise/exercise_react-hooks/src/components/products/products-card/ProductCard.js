"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = ProductCard;
require("./ProductCard.css");
const react_1 = __importDefault(require("react"));
function ProductCard({ product, unitPrice, categoryId, quantityPerUnit, onProductSelected }) {
    const productClicked = () => {
        onProductSelected(product);
    };
    return (<div className="card product-card" onClick={productClicked}>
            <div id="card-header" className="card-header">
                <div className="product-name">
                    {product}
                </div>
                <div className="product-price">
                    ${unitPrice}
                </div>
            </div>

            <div id="product-body" className="card-body">
                <p>Category ID: {categoryId}</p>
                <p>Quantity per Unit: {quantityPerUnit}</p>
            </div>
        </div>);
}
