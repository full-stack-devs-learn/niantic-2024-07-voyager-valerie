import productService from '../../../services/product-service'
import './ProductCard.css'
import React from 'react'

export default function ProductCard({product, unitPrice, categoryId, quantityPerUnit, onProductSelected})
{
    
    const productClicked = () => {
        onProductSelected(product);
    };

    return (
        <div className="card product-card" onClick={productClicked}>
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
        </div>
    )
}

