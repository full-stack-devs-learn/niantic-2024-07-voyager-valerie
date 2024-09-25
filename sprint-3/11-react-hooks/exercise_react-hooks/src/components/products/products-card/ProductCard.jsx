import './ProductCard.css'
import React from 'react'

const ProductCard = ({ product }) => {
    return (
        <div className="product-card">
            <h3>{product.productName}</h3>
            <p>{product.categoryId}</p>
            <p>Price: ${product.unitPrice}</p>
        </div>
    );
};

export default ProductCard;