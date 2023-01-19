import { Button, Card, CardActions, TextField, Typography } from "@mui/material"
import CardContent from '@mui/material/CardContent';
import { useState } from "react";

import { IEmployee } from "../interfaces/IEmployeeList"

// interface IProps {
//     key: number,
//     employee: IEmployee
// }

interface IProps {
    addEmployee: (name: string, email: string, age: number) => void
}

const NewEmployeeCard = (props: IProps) => {
    let [nameState, setNameState] = useState("")
    let [emailState, setEmailState] = useState("")
    let [ageState, setAgeState] = useState("10")

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
                    onClick={() => props.addEmployee(nameState, emailState, Number(ageState))}
                >Create New Employee</Button>
            </CardActions>
        </Card>
    )
}


export default NewEmployeeCard