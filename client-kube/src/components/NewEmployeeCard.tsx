import { Button, Card, CardActions, TextField } from "@mui/material"
import CardContent from '@mui/material/CardContent';
import { useState } from "react";

import { IEmployee } from "../interfaces/IEmployeeList"

interface IProps {
    addEmployee: (id: string, name: string, email: string, age: number) => void,
    employee: IEmployee
    setEditIndex: (x: string) => void
}

const NewEmployeeCard = (props: IProps) => {
    let [nameState, setNameState] = useState(props.employee.name)
    let [emailState, setEmailState] = useState(props.employee.email)
    let [ageState, setAgeState] = useState(props.employee.age.toString())

    return (
        <Card sx={{ maxWidth: 500, margin: 1 }}>
            <CardContent>
                <TextField
                    value={nameState}
                    onChange={(e) => { setNameState(e.target.value) }}
                    id="outlined-basic"
                    label="name"
                    variant="outlined" />
                <TextField
                    value={emailState}
                    onChange={(e) => { setEmailState(e.target.value) }}
                    id="outlined-basic"
                    label="email"
                    variant="outlined" />
                <TextField
                    value={ageState}
                    onChange={(e) => {
                        if (!isNaN(+e.target.value)) {
                            setAgeState(e.target.value)
                        }
                    }}
                    id="outlined-basic"
                    type="number"
                    label="age"
                    variant="outlined" />
            </CardContent>
            <CardActions>
                <Button
                    size="small"
                    onClick={() => props.addEmployee(props.employee.id, nameState, emailState, Number(ageState))}
                >{(props.employee.id === "asdf") ? "Create New Employee" : "Edit Employee"}</Button>
                {(props.employee.id === "asdf") ? <div></div> :
                    <Button
                        size="small"
                        onClick={() => props.setEditIndex("")}
                    >Cancel</Button>
                }
            </CardActions>
        </Card>
    )
}


export default NewEmployeeCard