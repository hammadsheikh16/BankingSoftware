import {
    AlertDialog,
    AlertDialogBody,
    AlertDialogFooter,
    AlertDialogHeader,
    AlertDialogContent,
    AlertDialogOverlay, Button,
} from '@chakra-ui/react'


export default function EmployeeLogin(){
    const { isOpen, onOpen, onClose } = useDisclosure()
    const cancelRef = React.useRef()

    return (
        <>
            <Button colorScheme={'blue'} onClick={onOpen}>

            </Button>

        </>
    )
}