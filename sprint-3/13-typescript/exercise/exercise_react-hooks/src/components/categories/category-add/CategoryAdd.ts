"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = CategoryAdd;
const react_1 = require("react");
const category_service_1 = __importDefault(require("../../../services/category-service"));
function CategoryAdd({ onCancel, onCategoryAdded }) {
    const [categoryName, setCategoryName] = (0, react_1.useState)('');
    const [description, setDescription] = (0, react_1.useState)('');
    function addCategoryHandler(event) {
        return __awaiter(this, void 0, void 0, function* () {
            event.preventDefault();
            const newCategory = {
                categoryName: categoryName,
                description: description
            };
            // call my api
            yield category_service_1.default.add(newCategory);
            onCategoryAdded();
        });
    }
    return (<div className="container">
        <h2>Add New Category</h2>
        <form onSubmit={addCategoryHandler}>
            <div className="row">
                <label htmlFor="category-name">Category Name:</label>
                <input type="text" className="form-control" name="category-name" id="category-name" onChange={(e) => setCategoryName(e.target.value)}/>
            </div>

            <div className="row">
                <label htmlFor="description">Description:</label>
                <textarea className="form-control" name="description" id="description" onChange={(e) => setDescription(e.target.value)}/>
            </div>
            <button className="btn btn-danger mr-3" type="submit">Add Category</button>
            <button className="btn btn-dark" type="cancel" onClick={onCancel}>Cancel</button>
        </form>
        </div>);
}
