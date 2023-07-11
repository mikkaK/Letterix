import GeneralBox from "../../molecules/GeneralBox";
import CoverLetterContentBox from "../../organisms/CoverLetterContentBox";
import { useLocation } from 'react-router-dom';


const CoverLetter = () => {
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);
    const encodedData:any = queryParams.get('data');
    const decodedObject = JSON.parse(decodeURIComponent(encodedData!));
    return (
       <GeneralBox title={"Your cover letter"} content={<CoverLetterContentBox decodedObject={decodedObject}/>}/>
    );
};

export default CoverLetter;
