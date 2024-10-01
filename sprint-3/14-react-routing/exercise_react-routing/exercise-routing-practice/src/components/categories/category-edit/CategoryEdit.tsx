import { useState, useEffect } from "react"
import axios from "axios"
import { useParams, useNavigate } from "react-router-dom"

export default function CategoryEdit()
{
    const { id } = useParams()
    const navigate = useNavigate()

    const [categoryName, setCategoryName] = useState('')
    const [description, setDescription] = useState('')

    useEffect(() => {
        const getCategory = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/categories/${id}`)
                const category = response.data

                setCategoryName(category.categoryName)
                setDescription(category.categoryDescription)
            }
            catch (error) {
                console.log('Error getting the category', error)
            }
        }

        getCategory()
    }, [id])

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        
        const updatedCategory = {
          categoryName,
          description
        };
    
        try {
          await axios.put(`http://localhost:8080/categories/${id}`, updatedCategory);
          alert('Category updated successfully!');
          navigate(`/categories/${id}`);  // redirect to product details page
        } catch (error) {
          console.error('Error updating the category', error);
        }
      }


    return (
        <div>
        <h2>Edit Category</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Category Name:</label>
            <input
              type="text"
              value={categoryName}
              onChange={(e) => setCategoryName(e.target.value)}
              required
            />
          </div>
          <div>
            <label>Description:</label>
            <input
              type="text"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
              required
            />
          </div>
          <button type="submit">Update Category</button>
        </form>
      </div>
    )
}