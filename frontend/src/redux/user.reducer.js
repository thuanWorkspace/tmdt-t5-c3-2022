import { createSlice } from "@reduxjs/toolkit";


const userSlice = createSlice({
    name: 'user',
    initialState: {
        token: null,
        auth: null,
        fetching: false,
        fail: false,
        success: false
    },
    reducers: {
        loginStart(state) {

        },
        loginFail(state) {

        },
        loginSuccess(state, action) {

        }
    }
})

export const { loginStart, loginFail, loginSuccess } = userSlice.actions;
export default userSlice.reducer;