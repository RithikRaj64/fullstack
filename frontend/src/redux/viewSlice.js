import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    insId: '',
    crsId: '',
    userId: '',
    applicationId: ''
}

const viewSlice = createSlice({
    name: 'view',
    initialState,
    reducers : {
        setInsId: (state, action) => {
            state.insId = action.payload
        },
        setCrsId: (state, action) => {
            state.crsId = action.payload
        },
        setUserId: (state, action) => {
            state.userId = action.payload
        },
        setApplicatioinId: (state, action) => {
            state.applicationId = action.payload
        }
    }
})

export const { setInsId, setCrsId, setUserId, setApplicatioinId } = viewSlice.actions;

export const getInsId = (state) => state.view.insId;
export const getCrsId = (state) => state.view.crsId;
export const getUserId = (state) => state.view.userId;
export const getApplicationId = (state) => state.view.applicationId;

export default viewSlice.reducer;