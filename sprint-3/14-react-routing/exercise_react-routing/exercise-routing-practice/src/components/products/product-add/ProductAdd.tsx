import { useState } from "react"
import axios from "axios"
import { useNavigate } from "react-router-dom"

export default function ProductAdd()
{
    const [productName, setProductName] = useState('')
    const [unitPrice, setUnitPrice] = useState('')
    const [categoryId, setCategoryId] = useState('')
    const navigate = useNavigate()

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()

        const addProduct = {
            productName,
            unitPrice: parseFloat(unitPrice),
            categoryId: parseInt(categoryId, 10)
        }

        try {
            await axios.post(`http://localhost:8080/products`, addProduct)
            alert('Product added successfully!')
            navigate('/products')
        }
        catch(error)
        {
            console.error('There was an error adding the product', error)
        }
    }

    return (
        <div>
            <h2>Add New Product</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Product Name:</label>
                    <input type="text"
                           value={productName}
                           onChange={(e) => setProductName(e.target.value)}
                           required
                    />
                </div>
                <div>
                    <label>Unit Price:</label>
                    <input type="number"
                           value={unitPrice}
                           onChange={(e) => setUnitPrice(e.target.value)}
                           required
                    />
                </div>
                <div>
                    <label>Category Id:</label>
                    <input type="number" 
                           value={categoryId}
                           onChange={(e) => setCategoryId(e.target.value)}
                           required
                    />
                </div>
                <button type="submit">Add Product</button>
            </form>
        </div>
    )
}