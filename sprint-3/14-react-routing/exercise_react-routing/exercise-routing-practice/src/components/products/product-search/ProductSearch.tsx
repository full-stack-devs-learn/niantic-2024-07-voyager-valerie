import { useState, useEffect } from "react"
import { useSearchParams } from "react-router-dom"
import { Product } from "../Product"
import axios from 'axios'

export default function ProductSearch()
{
    const [SearchParams] = useSearchParams()
    const [products, setProducts] = useState<Product[]>([])

    const minPrice = SearchParams.get('minPrice') 
    const maxPrice = SearchParams.get('maxPrice') 
    const productName = SearchParams.get('name') 
    const categoryId = SearchParams.get('catId') 

    useEffect(() => {
        const getProducts = async () => {
            const response = await axios.get(`http://localhost:8080/products`, {
                params: {
                    minPrice,
                    maxPrice,
                    productName,
                    categoryId
                }
            })
            setProducts(response.data)
        }

        getProducts()
    }, [minPrice, maxPrice, productName, categoryId])

    return (
        <div>
            <h1>Product Search</h1>
            <ul>
                {products.map((product) => (
                    <li key={product.productId}>{product.productName}: ${product.unitPrice}</li>
                ))}
            </ul>
        </div>
    )
}
