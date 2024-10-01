import { useParams } from "react-router-dom";

export default function ProductDetails()
{
    const params = useParams()

    return (
        <>
        <h4>Product Details - Product Id: {params.productId}</h4>
        </>
    )
}