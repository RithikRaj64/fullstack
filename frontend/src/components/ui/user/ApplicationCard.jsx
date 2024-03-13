import PropTypes from "prop-types";
import { getFee, pay } from "../../../services/user";
import { paid } from "../../../services/institute";
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

    const handlePayment = async () => {
        let fee = await getFee(data.courseId);
        let details = {
            "amount" : parseFloat(fee.data.message),
            "transactionType" : "UPI",
            "applicationId" : data.id
        };

        
        console.log(details);

        let res = await pay(details);
        let r = await paid(data.id);
        console.log(r.data);
        console.log(res.data);
    }

    return (
        <div className="w-full bg-sky-200 border border-gray-200 p-5 font-mono rounded-xl shadow">
                <a href="#">
                    <h3 className="mb-2 text-md font-bold tracking-tighter hover:tracking-normal">Application Id : {data.id}</h3>
                </a>
                <p className="mb-2 font-normal text-gray-700 tracking-tighter">Course Name : {data.courseName}</p>
                <p className="mb-5 font-normal text-gray-700 tracking-tighter">Status : {data.status}</p>

                {
                    (data.status === "Accepted") ? 
                        <>
                            <button className="bg-green-600 hover:bg-green-800 border border-gray-200 rounded-lg p-1 px-3 text-white" onClick={handlePayment}>Make Payment</button>
                        </> : <></>
                }
        </div>
    )
}

ApplicationCard.propTypes = {
    data : PropTypes.shape({
        id: PropTypes.string.isRequired,
        courseName: PropTypes.string.isRequired,
        status: PropTypes.string.isRequired,
        courseId: PropTypes.string.isRequired,
    }).isRequired
}


export default ApplicationCard;