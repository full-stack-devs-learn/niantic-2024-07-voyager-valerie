"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const react_1 = require("react");
const Header_1 = __importDefault(require("./components/header/Header"));
const CategoriesPage_1 = __importDefault(require("./components/categories/cagtegories-page/CategoriesPage"));
const ProductsPage_1 = __importDefault(require("./components/products/products-page/ProductsPage"));
function App() {
    const [pageName, setPageName] = (0, react_1.useState)("categories");
    const pageChangeHanlder = (newPage) => {
        setPageName(newPage);
        console.log("changing page to: " + pageName);
    };
    console.log("page render: " + pageName);
    return (<>
      <Header_1.default onPageChanged={pageChangeHanlder}></Header_1.default>

      {(pageName == "categories") ? <CategoriesPage_1.default></CategoriesPage_1.default> : null}
      {(pageName == "products") && <ProductsPage_1.default></ProductsPage_1.default>}
    </>);
}
exports.default = App;
