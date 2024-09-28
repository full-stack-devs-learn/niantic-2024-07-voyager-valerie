import { Products } from "./products"

export class ProductsResponse
{
    id!: number
    name!: string
    categoryId?: number
    quantityPerUnit?: string
    unitPrice?: number
}