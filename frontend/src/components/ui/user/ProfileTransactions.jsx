import PropTypes from "prop-types";

function ProfileTransactions({data}) {
  return (
    <div className="bg-sky-200 rounded-lg p-8 space-y-6 ">
      <div className="grid grid-cols-2">
        <div className="flex flex-col space-y-6">
          <div>
            <p className="font-bold">Amount</p>
            <p className="">₹ {(data.amount).toLocaleString("en-IN")}</p>
          </div>
          <div>
            <p className="font-bold">Date</p>
            <p className="">{new Date(data.date).toUTCString()}</p>
          </div>
          <div>
            <p className="font-bold">Application ID</p>
            <p>{data.applicationId}</p>
          </div>
        </div>
        <div className="flex flex-col space-y-6">   
          <div>
            <p className="font-bold">Transaction Type</p>
            <p className="">{data.transactionType}</p>
          </div>
          <div>
            <p className="font-bold">Transaction ID</p>
            <p className="">{data.id}</p>
          </div>
        </div>
      </div>
    </div>
  );
}

ProfileTransactions.propTypes = {
  data : PropTypes.shape({
      id: PropTypes.string.isRequired,
      amount: PropTypes.number.isRequired,
      transactionType: PropTypes.string.isRequired,
      applicationId: PropTypes.string.isRequired,
      date: PropTypes.any.isRequired,
  }).isRequired
}

export default ProfileTransactions;

