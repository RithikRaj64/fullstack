import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    isAuthenticated : false,
    accessToken : '',
    role : '',
    id : '',
    name: ''
}

const authSlice = createSlice({
    name : 'auth',
    initialState,
    reducers : {
        setAuthenthenicated: (state,action) => {
            state.isAuthenticated = action.payload;
        },
        setToken: (state, action)=> {
            state.accessToken = action.payload
        },
        setRole: (state, action)=> {
            state.role = action.payload
        },
        setId: (state, action)=> {
            state.id = action.payload
        },
        setName: (state, action) => {
            state.name = action.payload
        },
        logoutRedux: (state) => {
            Object.assign(state, initialState)
        }
    }
})

export const {setAuthenthenicated, setToken, setRole, setId, setName, logoutRedux} = authSlice.actions

export const getAccessToken = (state) => state.auth.accessToken
export const getId = (state) => state.auth.id
export const getName = (state) => state.auth.name

export default authSlice.reducer;
