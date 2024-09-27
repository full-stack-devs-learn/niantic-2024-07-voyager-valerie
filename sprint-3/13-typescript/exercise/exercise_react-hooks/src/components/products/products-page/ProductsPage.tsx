import './ProductsPage.css'
import ProductCardContainer from '../product-card-container/ProductCardContainer'
import { useState } from 'react'

export default function ProductsPage()
{
    const  [action, setAction] = useState("list");

    return (
        <>
        <div className="container">
            <header className="mt-4">
                <h1>Products</h1>
            </header>

            <button className="btn btn-danger" onClick={() => setAction("add")}>Add Product</button>

            {action === "list" && <ProductCardContainer></ProductCardContainer>}
            {/* {action === "add" && <ProductAdd on} */}
        </div>

        </>
    )
}

