import { AppBar, Box, IconButton, MenuItem, Popover, TextField, Toolbar, Typography } from "@mui/material";
import React, { useState } from "react";


interface IUserDetails {
    username: string,
    password: string
}

interface IProps {
    userDetails: IUserDetails
    setUserDetails: React.Dispatch<React.SetStateAction<IUserDetails>>
}

const TopAppBar = (props: IProps) => {

    let [username, setUsername] = useState("")
    let [password, setPassword] = useState("")

    const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

    const handleMenu = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const mountUserDetails = () => {
        props.setUserDetails({
            username: username,
            password: password
        })
        setUsername("")
        setPassword("")
    }

    const unmountUserDetails = () => {
        props.setUserDetails({
            username: "",
            password: ""
        })
        setUsername("")
        setPassword("")
    }

    return (

        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h2" component="div" sx={{ flexGrow: 1 }}>
                        Kubernetes App Java
                    </Typography>
                    <IconButton
                        size="large"
                        aria-label="account of current user"
                        aria-controls="menu-appbar"
                        aria-haspopup="true"
                        onClick={handleMenu}
                        color="inherit"
                    >
                        {(props.userDetails.username === "" && props.userDetails.password === "") ? "unknown" : props.userDetails.username}
                    </IconButton>
                    <Popover
                        id="menu-appbar"
                        anchorEl={anchorEl}
                        anchorOrigin={{
                            vertical: 'top',
                            horizontal: 'right',
                        }}
                        keepMounted
                        transformOrigin={{
                            vertical: 'top',
                            horizontal: 'right',
                        }}
                        open={Boolean(anchorEl)}
                        onClose={handleClose}
                    >
                        <Typography>{(props.userDetails.username === "" && props.userDetails.password === "") ? "unknown" : props.userDetails.username}</Typography>
                        <TextField
                            value={username}
                            onChange={(e) => { setUsername(e.target.value) }}
                            id="outlined-basic"
                            label="username"
                            variant="outlined"
                            InputProps={{ style: { fontSize: 12 } }}
                            InputLabelProps={{ style: { fontSize: 12 } }}
                        />
                        <TextField
                            value={password}
                            onChange={(e) => { setPassword(e.target.value) }}
                            id="outlined-basic"
                            label="password"
                            variant="outlined"
                            InputProps={{ style: { fontSize: 12 } }}
                            InputLabelProps={{ style: { fontSize: 12 } }}
                        />
                        {(props.userDetails.username === "" && props.userDetails.password === "") ? <MenuItem onClick={mountUserDetails}>login</MenuItem> :
                            <MenuItem onClick={unmountUserDetails}>logout</MenuItem>}
                    </Popover>
                </Toolbar>
            </AppBar>
        </Box>
    )
}

export default TopAppBar;