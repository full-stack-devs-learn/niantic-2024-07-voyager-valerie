import { useState, useEffect } from 'react'
import axios from 'axios'
import './ProductsList.css'

export default function ProductsList({categoryId})
{
    // const [products, setProducts] = useState([]);
    // const [error, setError] = useState(null);
    
    // // call the products api - getProductsByCategoryId
    
    // useEffect(() => {
    //     if (categoryId===0) {
    //         setProducts([]);
    //         return;
    //     }

    //     const getProducts = async () => {
    //         try
    //         {
    //             const response = await axios.get(`http://localhost:8080/products/${categoryId}`);
    //         }
    //         catch (error)
    //         {
    //             setError(error.message);
    //         }
    //     };

    //     getProducts();
    // }, [categoryId]);

    return (
        <>
        {(categoryId == 0) 
        ? <div>No Category Selected</div>
        : <h3>
                Products for category: {categoryId}
          </h3>
        }
        </>
    )
}