import { Card, Typography } from "@mui/material"
import CardContent from '@mui/material/CardContent';

import React from "react"
import { IEmployee } from "../interfaces/IEmployeeList"

interface IProps {
    key:number,
    employee: IEmployee
}

const EmployeeCard = (props : IProps) => {

    return(
        <Card sx={{ maxWidth: 300, margin:1 }}>
            <CardContent>
                <Typography>
                    {props.employee.name}
                </Typography>
                <Typography>
                    {props.employee.email}
                </Typography>
                <Typography>
                    {props.employee.age}
                </Typography>
                <p>
                    hello
                </p>
            </CardContent>
        </Card>
    )
}


export default EmployeeCard