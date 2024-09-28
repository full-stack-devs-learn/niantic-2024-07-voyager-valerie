"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = Header;
require("./Header.css");
function Header({ onPageChanged }) {
    return (<div id="navigation">
            <img src="images/logo.png" alt="Northwind Logo"/>
            <h1>Northwind Traders</h1>

            <div className="link" onClick={() => onPageChanged("categories")}>Categories</div>
            <div className="link" onClick={() => onPageChanged("products")}>Products</div>
        </div>);
}
