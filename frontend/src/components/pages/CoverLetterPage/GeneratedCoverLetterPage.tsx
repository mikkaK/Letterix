import GeneralBox from "../../molecules/GeneralBox";
import CoverLetterContentBox from "../../organisms/CoverLetterContentBox";

const CoverLetter = () => {

    return (
       <GeneralBox title={"Your cover letter"} content={<CoverLetterContentBox/>}/>
    );
};

export default CoverLetter;
