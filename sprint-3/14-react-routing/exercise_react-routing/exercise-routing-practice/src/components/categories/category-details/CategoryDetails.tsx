import { useParams } from "react-router-dom";

export default function CategoryDetails()
{
    const params = useParams()

    return (
        <>
            <h4>Category Details - Category Id: {params.categoryId}</h4>
        </>
    )
}