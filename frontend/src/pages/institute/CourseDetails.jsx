import { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { getCrsId } from '../../redux/viewSlice';
import { deleteCourse, getCourse } from '../../services/institute';

function CourseDetail() {

    const id = useSelector(getCrsId);

    const [details, setDetails] = useState({});

    const getDetails = async () => {
        let res = await getCourse(id);
        setDetails(res.data);
        console.log(res.data);
        return;
    }

    const handleDelete = async () => {
        let res = await deleteCourse(id);
        console.log(res.data);
    }

    useEffect(() => {
       getDetails(); 
    }, []);

    return (
        <div className="bg-sky-200 p-12 min-h-screen flex items-center">
            <div className="bg-white rounded-xl border border-gray-200 min-w-screen min-h-fit px-32 p-20 font-mono">
                <div className="col-span-2 flex justify-center items-center">
                    <div>

                        <div>
                            <h1 className="text-3xl font-bold tracking-tighter mb-1">{details.courseName}</h1>
                            <p className="font-normal tracking-tighter mb-10">{details.instituteName}</p>
                        </div>

                        <div>
                            <p className="font-normal tracking-tighter mb-10">{details.description}</p>
                        </div>
                        
                        <div className="leading-7 mb-10">

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Degree level</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.degreeLevel}</p>
                            </div>

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Duration</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.duration}</p>
                            </div>

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Semesters</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.noOfSemesters}</p>
                            </div>

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Fee per year</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">Rs.{details.fees}</p>
                            </div>

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Total Seats</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.totalSeats}</p>
                            </div>

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Available</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.availableSeats}</p>
                            </div>

                            <div className="grid grid-cols-7 space-x-6">
                                <p className="font-normal tracking-tighter">Accepted</p>
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.acceptedStudents}</p>
                            </div>

                        </div>

                        <div className="space-x-2">
                        <button onClick={handleDelete} className="inline-flex justify-center text-white bg-red-600 hover:bg-red-800 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:ring-red-300 focus:outline-none">
                            Delete
                        {/* <svg width="16" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#ffffff"><g id="SVGRepo_bgCarrier" strokeWidth="0"></g><g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"></g><g id="SVGRepo_iconCarrier"> <path d="M10 11V17" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M14 11V17" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M4 7H20" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M6 7H12H18V18C18 19.6569 16.6569 21 15 21H9C7.34315 21 6 19.6569 6 18V7Z" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> <path d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z" stroke="#000000" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"></path> </g></svg> */}
                        <svg className="rtl:rotate-180 w-4 h-4 ms-2 mt-0.5" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#000000">
                            <g id="SVGRepo_bgCarrier" strokeWidth="0"/>
                            <g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"/>
                            <g id="SVGRepo_iconCarrier"> <path d="M10 11V17" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M14 11V17" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M4 7H20" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M6 7H12H18V18C18 19.6569 16.6569 21 15 21H9C7.34315 21 6 19.6569 6 18V7Z" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> <path d="M9 5C9 3.89543 9.89543 3 11 3H13C14.1046 3 15 3.89543 15 5V7H9V5Z" stroke="#ffffff" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round"/> </g>
                        </svg>
                    </button>
                        </div>
                    </div>
                </div>
            </div>

            
        </div>
    )
}

export default CourseDetail;