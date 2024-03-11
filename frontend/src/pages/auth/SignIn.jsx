import { useState } from "react";

import { useDispatch } from "react-redux";
import { setAuthenthenicated, setToken, setRole, setId, setName } from "../../redux/authSlice";

import { jwtDecode } from "jwt-decode";

import { signIn } from "../../services/auth";
import { useNavigate } from "react-router-dom";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import SignInPic from "../../assets/images/SignIn.jpg";

function SignIn() {

    const nav = useNavigate();
    const dispatch = useDispatch();

    const [data, setData] = useState({});

    const handleChange = (e) => {
        setData({
            ...data,
            [e.target.name]: e.target.value,
        });
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            let details = {
                "email" : data.email,
                "password" : data.password
            };

            let response = await signIn(details);
            console.log(response);
            
            if(response.status === 200) {
                const { accessToken, id, name } = response.data;

                sessionStorage.setItem("token", accessToken);

                let role = jwtDecode(accessToken)?.role;
                dispatch(setAuthenthenicated(true));
                dispatch(setToken(accessToken));
                dispatch(setRole(role));
                dispatch(setId(id));
                dispatch(setName(name));

                if(role === "ADMIN") {
                    toast.success(response.data.message, {
                        onClose: () => {
                            nav("/admin/dashboard");
                        }
                    });
                }
                else if(role === "STUDENT") {
                    toast.success(response.data.message, {
                        onClose: () => {
                            nav("/user/home");
                        }
                    });
                }
                else {
                    toast.success(response.data.message, {
                        onClose: () => {
                            nav("/institute/profile");
                        }
                    });
                }
            }
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <>
            <ToastContainer />
            <div className="grid grid-cols-3 overflow-clip">
                <div className="col-span-2">
                    <img
                        className="p-20 ml-32 sm:rounded-lg"
                        src={SignInPic}
                    />
                </div>
                <div className="bg-sky-200 flex min-h-screen flex-1 flex-col justify-center px-6 py-12 lg:px-8">
                    <div className="bg-white p-6 rounded-lg">
                    <div className="sm:mx-auto sm:w-full sm:max-w-sm">
                        <h2 className="text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
                            Sign in to your account
                        </h2>
                    </div>


                    <div className="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
                        <div className="space-y-6">
                            
                            <div>
                                <label
                                    htmlFor="email"
                                    className="block text-sm font-medium leading-6 text-gray-900"
                                >
                                    Email address
                                </label>
                                <div className="mt-2">
                                    <input
                                        id="email"
                                        name="email"
                                        type="email"
                                        autoComplete="email"
                                        onChange={handleChange}
                                        required
                                        className="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                    />
                                </div>
                            </div>

                            <div>
                                <div className="flex items-center justify-between">
                                    <label
                                        htmlFor="password"
                                        className="block text-sm font-medium leading-6 text-gray-900"
                                    >
                                        Password
                                    </label>
                                </div>
                                <div className="mt-2">
                                    <input
                                        id="password"
                                        name="password"
                                        type="password"
                                        autoComplete="current-password"
                                        onChange={handleChange}
                                        required
                                        className="block w-full rounded-md border-0 px-2 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                    />
                                </div>
                            </div>

                            <div>
                                <button
                                    onClick={handleSubmit}
                                    className="flex w-full justify-center rounded-md bg-blue-600 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-sky-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
                                >
                                    Sign in
                                </button>
                            </div>
                        </div>

                        <p className="mt-10 text-center text-sm text-gray-500">
                            Not a member?{" "}
                            <a
                                href="/signup"
                                className="font-semibold leading-6 text-blue-600 hover:underline hover:underline-offset-8"
                            >
                                Sign Up
                            </a>
                        </p>
                    </div>
                </div>
                </div>
            </div>
        </>
    );
}

export default SignIn;