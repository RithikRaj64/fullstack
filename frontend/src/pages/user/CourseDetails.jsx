import { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { getCrsId } from '../../redux/viewSlice';
import { getCourse } from '../../services/institute';
import { getId } from '../../redux/authSlice';
import { apply, getAllApplications, getStuId } from '../../services/user';

function CourseDetail() {
    const id = useSelector(getCrsId);

    const userId = useSelector(getId);

    const [details, setDetails] = useState({});

    const getDetails = async () => {
        let res = await getCourse(id);
        setDetails(res.data);
        console.log(res.data);
        let apps = await getAllApplications();
        console.log(apps.data);
        return;
    }

    const handleApply = async () => {
        let stuId = await getStudId();
        let data = {
            "studentId" : stuId,
            "courseId" : id
        }

        let res = await apply(data);

        console.log(res.data);
    } 

    const getStudId = async () => {
        let res = await getStuId(userId);
        return res.data.message;
    }

    useEffect(() => {
        getDetails(); 
    }, []);

    return (
        <div className="bg-sky-200 p-12 min-h-fit">
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
                                <p className="font-normal grid grid-cols-subgrid col-span-6 tracking-tighter">{details.duration} years</p>
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

                        </div>

                        <div className="space-x-2">
                        
                            <button onClick={handleApply} className="inline-flex text-white bg-green-600 hover:bg-green-800 hover:px-5 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                                Apply Now
                                <svg className="rtl:rotate-180 w-4 h-4 ms-2 mt-1" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" fill="#ffffff" stroke="#ffffff">
                                    <g id="SVGRepo_bgCarrier" strokeWidth="0"/>
                                    <g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"/>
                                    <g id="SVGRepo_iconCarrier"> <title/> <g fill="none" fillRule="evenodd" id="页面-1" stroke="none" strokeLinecap="round" strokeWidth="1"> <g id="导航图标" stroke="#ffffff" strokeWidth="1.5" transform="translate(-103.000000, -334.000000)"> <g id="申请" transform="translate(103.000000, 334.000000)"> <g id="路径" transform="translate(4.000000, 2.000000)"> <path d="M16,14.5 L16,19 C16,19.5523 15.5523,20 15,20 L11.75,20" strokeLinejoin="round"/> <path d="M16,6 L16,1 C16,0.447715 15.5523,0 15,0 L1,0 C0.447715,0 0,0.447715 0,1 L0,19 C0,19.5523 0.447715,20 1,20 L4,20" strokeLinejoin="round"/> <line x1="4" x2="11" y1="6" y2="6"/> <line x1="7.5" x2="16" y1="20" y2="9.5"/> <line x1="4" x2="8" y1="10" y2="10"/> </g> </g> </g> </g> </g>
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