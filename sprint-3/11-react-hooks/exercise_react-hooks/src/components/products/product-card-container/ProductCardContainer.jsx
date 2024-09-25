import { useState, useEffect } from "react"
import './ProductCardContainer.css'
import productService from "../../../services/product-service"
import ProductCard from "../products-card/ProductCard"

const ProductCardContainer = () => {

    const [products, setProducts] = useState([]);

    useEffect (() => {
        getAllProducts();
    },
    []);

    async function getAllProducts()
    {
        const result = await productService.getAllProducts();
        setProducts(result);
    }
}