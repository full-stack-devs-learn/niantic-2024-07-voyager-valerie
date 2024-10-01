import { useState, useEffect } from "react"
import axios from "axios"
import { useParams, useNavigate } from "react-router-dom"

export default function ProductEdit()
{
    const { id } = useParams()
    const navigate = useNavigate()

    const [productName, setProductName] = useState('')
    const [unitPrice, setUnitPrice] = useState('')
    const [categoryId, setCategoryId] = useState('')

    useEffect(() => {
        const getProduct = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/products/${id}`)
                const product = response.data

                setProductName(product.productName)
                setUnitPrice(product.unitPrice)
                setCategoryId(product.categoryId)
            }
            catch (error) {
                console.log('Error getting the product', error)
            }
        }

        getProduct()
    }, [id])

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        
        const updatedProduct = {
          productName,
          unitPrice: parseFloat(unitPrice),
          categoryId: parseInt(categoryId, 10),
        };
    
        try {
          await axios.put(`http://localhost:8080/products/${id}`, updatedProduct);
          alert('Product updated successfully!');
          navigate(`/products/${id}`);  // redirect to product details page
        } catch (error) {
          console.error('Error updating the product', error);
        }
      }


    return (
        <div>
        <h2>Edit Product</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Product Name:</label>
            <input
              type="text"
              value={productName}
              onChange={(e) => setProductName(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Unit Price:</label>
            <input
              type="number"
              value={unitPrice}
              onChange={(e) => setUnitPrice(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Category ID:</label>
            <input
              type="number"
              value={categoryId}
              onChange={(e) => setCategoryId(e.target.value)}
              required
            />
          </div>
          <button type="submit">Update Product</button>
        </form>
      </div>
    )
}
