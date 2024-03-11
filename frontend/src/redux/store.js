import { combineReducers } from "redux";
import authSlice from "./authSlice";
import viewSlice from "./viewSlice";
import sessionStorage from "redux-persist/es/storage/session";
import { persistReducer, persistStore } from "redux-persist";
import { configureStore } from "@reduxjs/toolkit";

const rootReducer = combineReducers({
    auth: authSlice,
    view: viewSlice
})

const persistConfig = {
    key:'root',
    storage: sessionStorage
}

const persistedReducer = persistReducer(persistConfig, rootReducer);

const Store = configureStore({
    reducer: persistedReducer,
    middleware: (getDefaultMiddleware) => getDefaultMiddleware({
        serializableCheck: false
    })
})

export const persistor = persistStore(Store);
export default Store;
