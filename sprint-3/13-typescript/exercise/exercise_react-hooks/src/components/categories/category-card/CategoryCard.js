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
exports.default = CategoryCard;
const category_service_1 = __importDefault(require("../../../services/category-service"));
require("./CategoryCard.css");
const react_bootstrap_icons_1 = require("react-bootstrap-icons");
function CategoryCard({ id, category, onCategorySelected, onCategoryDeleted }) {
    const imageUrl = `images/categories/${id}.webp`;
    const categoryClicked = () => {
        // console.log(id)
        // console.log(category); 
        onCategorySelected(category);
    };
    function deleteCategory(event) {
        return __awaiter(this, void 0, void 0, function* () {
            event.stopPropagation();
            yield category_service_1.default.delete(id);
            onCategoryDeleted(id);
        });
    }
    return (<div className="card category-card" onClick={categoryClicked}>
            <div id="category-header" className="card-header">{category}</div>
            <div id="category-body" className="card-body">
                <img id="category-image" src={imageUrl}/>
            </div>
            <div className="card-footer">
                <react_bootstrap_icons_1.XCircleFill onClick={deleteCategory} color="red"/>
            </div>
        </div>);
}
