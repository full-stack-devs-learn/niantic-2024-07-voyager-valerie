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
    []);

     const productSelected = (name) => 
     {
        setSelectedProductId(name);

         const currentProduct = products.filter(product => product.name === name)[0];

         setSelectedProduct(currentProduct.name);
         setSelectedProductId(currentProduct.id);
     }

    return(
        <>
            <h5 className="container"> Selected Product: {selectedProduct} </h5>
            <main className="container mt-4 products-container" id="products-container">
            {
                products.map((product) => (
                    <ProductCard 
                        key={product.id}
                        id={product.id}
                        product={product.name}
                        categoryId={product.categoryId}
                        quantityPerUnit={product.quantityPerUnit}
                        unitPrice={product.unitPrice}
                        onProductSelected={productSelected}
                    ></ProductCard>
                ))
            }
            </main>
        </>
    )
}