import PropTypes from "prop-types";
import { accept, reject } from "../../../services/institute";
// import { useNavigate } from "react-router-dom";

// import { useDispatch } from "react-redux";
// import { setCrsId } from "../../../redux/viewSlice";

function ApplicationCard({data}) {

    // const nav = useNavigate();
    // const dispatch = useDispatch();

    
    // const handleClick = () => {
    //     dispatch(setCrsId(data.id));
    //     nav("/user/course/view");
    // }

    const handleAccept = async () => {
        let res = await accept(data.id);
        console.log(res.data.message);
    }

    const handleReject = async () => {
        let res = await reject(data.id);
        console.log(res.data.message);
    }

    return (
        <div className="w-full flex flex-row bg-white border border-gray-200 rounded-xl shadow m-5">
            <div className="p-5 font-mono">
                <a href="#">
                    <h3 className="mb-2 text-md font-bold tracking-tighter hover:tracking-normal">Application Id : {data.id}</h3>
                </a>
                <p className="mb-2 font-normal text-gray-700 tracking-tighter">Course Name : {data.courseName}</p>
                <p className="mb-5 font-normal text-gray-700 tracking-tighter">Status : {data.status}</p>
                <div className="grid grid-cols-2 justify-center space-x-2 text-sm min-w-md max-w-md">
                    <button onClick={handleAccept} className="inline-flex justify-center text-white bg-green-600 hover:bg-green-800  px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:outline-none">
                        Accept Application
                        <svg className="rtl:rotate-180 w-4 h-4 ms-2 mt-1" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" fill="#ffffff" stroke="#ffffff">
                            <g id="SVGRepo_bgCarrier" strokeWidth="0"/>
                            <g id="SVGRepo_tracerCarrier" strokeLinecap="round" strokeLinejoin="round"/>
                            <g id="SVGRepo_iconCarrier"> <title/> <g fill="none" fillRule="evenodd" id="页面-1" stroke="none" strokeLinecap="round" strokeWidth="1"> <g id="导航图标" stroke="#ffffff" strokeWidth="1.5" transform="translate(-103.000000, -334.000000)"> <g id="申请" transform="translate(103.000000, 334.000000)"> <g id="路径" transform="translate(4.000000, 2.000000)"> <path d="M16,14.5 L16,19 C16,19.5523 15.5523,20 15,20 L11.75,20" strokeLinejoin="round"/> <path d="M16,6 L16,1 C16,0.447715 15.5523,0 15,0 L1,0 C0.447715,0 0,0.447715 0,1 L0,19 C0,19.5523 0.447715,20 1,20 L4,20" strokeLinejoin="round"/> <line x1="4" x2="11" y1="6" y2="6"/> <line x1="7.5" x2="16" y1="20" y2="9.5"/> <line x1="4" x2="8" y1="10" y2="10"/> </g> </g> </g> </g> </g>
                        </svg> 
                    </button> 
                    <button onClick={handleReject} className="inline-flex justify-center text-white bg-red-600 hover:bg-red-800 px-3 py-2 rounded-lg font-medium text-center focus:ring-4 focus:ring-red-300 focus:outline-none">
                        Reject Application
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
    )
}

ApplicationCard.propTypes = {
    data : PropTypes.shape({
        id: PropTypes.string.isRequired,
        courseName: PropTypes.string.isRequired,
        status: PropTypes.string.isRequired,
    }).isRequired
}


export default ApplicationCard;