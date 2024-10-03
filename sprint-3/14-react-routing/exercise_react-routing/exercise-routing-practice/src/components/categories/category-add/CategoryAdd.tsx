import { useState } from "react"
import axios from "axios"
import { useNavigate } from "react-router-dom"

export default function CategoryAdd()
{
    const [categoryName, setCategoryName] = useState('')
    const [description, setDescription] = useState('')
    const navigate = useNavigate()

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()

        const addCategory = {
            categoryName,
            description
        }

        try {
            await axios.post(`http://localhost:8080/categories`, addCategory)
            alert('Category added successfully!')
            navigate('/categories')
        }
        catch (error)
        {
            console.error('There was an error adding this category', error)
        }
    }

    return (
        <div>
            <h2>Add New Category</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Category Name:</label>
                    <input type="text" 
                           value={categoryName}
                           onChange={(e) => setCategoryName(e.target.value)}
                           required
                    />
                </div>
                <div>
                    <label>Description:</label>
                    <input type="text" 
                           value={description}
                           onChange={(e) => setDescription(e.target.value)}
                           required
                    />
                </div>
                <button type="submit" className="btn btn-primary mb-3">Add Category</button>
            </form>
        </div>
        
    )
}