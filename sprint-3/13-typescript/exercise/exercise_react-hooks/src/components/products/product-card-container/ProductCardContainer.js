"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = ProductCardContainer;
const react_1 = require("react");
require("./ProductCardContainer.css");
const product_service_1 = __importDefault(require("../../../services/product-service"));
const ProductCard_1 = __importDefault(require("../products-card/ProductCard"));
function ProductCardContainer() {
    const [selectedProduct, setSelectedProduct] = (0, react_1.useState)("None Selected");
    const [selectedProductId, setSelectedProductId] = (0, react_1.useState)(0);
    const [products, setProducts] = (0, react_1.useState)([]);
    (0, react_1.useEffect)(() => {
        product_service_1.default.getAllProducts().then(data => {
            setProducts(data);
        });
    }, []);
    const productSelected = (name) => {
        setSelectedProductId(name);
        const currentProduct = products.filter(product => product.name === name)[0];
        setSelectedProduct(currentProduct.name);
        setSelectedProductId(currentProduct.id);
    };
    return (<>
            <h5 className="container"> Selected Product: {selectedProduct} </h5>
            <main className="container mt-4 products-container" id="products-container">
            {products.map((product) => (<ProductCard_1.default key={product.id} id={product.id} product={product.name} categoryId={product.categoryId} quantityPerUnit={product.quantityPerUnit} unitPrice={product.unitPrice} onProductSelected={productSelected}></ProductCard_1.default>))}
            </main>
        </>);
}
