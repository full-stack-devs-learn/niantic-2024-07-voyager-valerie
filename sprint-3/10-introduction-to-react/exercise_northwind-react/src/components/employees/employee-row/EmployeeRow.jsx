import './EmployeeRow.css'

export default function EmployeeRow({id, firstName, lastName, title, onEmployeeSelected})
{
    const imageUrl = `images/employees/${id}.webp`

    const employeeClicked = () => {
        onEmployeeSelected(firstName, lastName)
    }

    return(
        <div className="employee-row" onClick={employeeClicked}>
        <img id="employee-image"
             src={imageUrl}
             alt={`${firstName} ${lastName}`} 
        />
        <div className="employee-name">
            <h1>{firstName} {lastName}</h1>
            <h6>{title}</h6>
        </div>
        </div>
    )
}