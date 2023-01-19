import { Button, Typography } from "@mui/material";
import { color } from "@mui/system";
import React from "react"

interface IProps {
    pageNum: number;
    backPage: (pageNumb: number) => void
    forwardPage: (pageNumb: number) => void
}

const PageBar = (props: IProps) => {
    return (
        <div style={
            {
                borderRadius: 10,
                backgroundColor: "#1976d2",
                maxWidth: "500px",
                margin: "0px auto"
            }
        }>
            <Button sx={{ color: 'white' }} onClick={() => props.backPage(props.pageNum)}>previous page</Button>
            <Typography className="page-num" sx={{ color: 'white' }}>{props.pageNum + 1}</Typography>
            <Button sx={{ color: 'white' }} onClick={() => props.forwardPage(props.pageNum)}>next page</Button>
        </div>
    )
}

export default PageBar