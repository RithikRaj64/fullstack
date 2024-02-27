function ProfileTransactions() {
  return (
    <div className="bg-sky-200 rounded-lg p-8 space-y-6 ">
      <div className="grid grid-cols-2">
        <div className="flex flex-col space-y-6">
          <div>
            <p className="font-bold">Amount</p>
            <p className="">₹ {(100000).toLocaleString("en-IN")}</p>
          </div>
          <div>
            <p className="font-bold">Date</p>
            <p className="">{new Date().toUTCString()}</p>
          </div>
          <div>
            <p className="font-bold">Status</p>
            <p>Success</p>
          </div>
        </div>
        <div className="flex flex-col space-y-6">   
          <div>
            <p className="font-bold">Transaction Type</p>
            <p className="">UPI</p>
          </div>
          <div>
            <p className="font-bold">Transaction ID</p>
            <p className="">85632475596</p>
          </div>
        </div>
      </div>
      <div className="grid grid-cols-2">
        <div className="">
            <p className="font-bold">Course</p>
            <p className="">B.E. (Computer Science and Engineering)</p>
        </div>
        <div className="">
            <p className="font-bold">Institute</p>
            <p className="">Sri Krishna College of Engineering and Technology</p>
        </div>
      </div>
    </div>
  );
}

export default ProfileTransactions;

