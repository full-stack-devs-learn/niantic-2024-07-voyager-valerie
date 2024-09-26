import { useState, useEffect } from "react"
import './ProductCardContainer.css'
import productService from "../../../services/product-service"
import ProductCard from "../products-card/ProductCard"

export default function ProductCardContainer()  
{
    const [selectedProduct, setSelectedProduct] = useState("None Selected");
    const [selectedProductId, setSelectedProductId] = useState(0);
    const [products, setProducts] = useState([]);

    useEffect (() => {
        productService.getAllProducts().then(data => {
            setProducts(data);
        });
    },
    [])

    const productSelected = (name) => 
    {
        setSelectedProduct(name);

        const productId = products.filter(product => product.productName === name)[0].productId;

        setSelectedProductId(productId);
    }

    return(
        <>
            <h5 className="container"> Selected Product: {selectedProduct} </h5>
            <main className="container mt-4 products-container" id="products-container">
            {
                products.map((product) => (
                    <ProductCard key={product.productId}
                        product={product.productName}
                        id={product.productId}
                        onProductSelected={productSelected}
                    ></ProductCard>
                ))
            }
            </main>
        </>
    )
}