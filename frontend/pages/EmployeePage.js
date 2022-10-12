import {Box, HStack, Spacer, Text, VStack, Center, Button} from "@chakra-ui/react";
import {
    Table,
    Thead,
    Tbody,
    Tfoot,
    Tr,
    Th,
    Td,
    TableCaption,
    TableContainer,
} from '@chakra-ui/react'

export default function EmployeePage(){
    return (
        <Box p={5}>
            <Table variant={'striped'} colorScheme={'teal'}>
                <Thead>
                    <Tr>
                        <Th>Account ID</Th>
                        <Th>Balance</Th>
                    </Tr>
                </Thead>

                <Tbody>
                    <Tr>
                        <Td>someID</Td>
                        <Td>1247981247</Td>
                    </Tr>
                {/*    Every entry will be in Tr tags with
                       2 corresponding Td tags for both pieces of data*/}
                </Tbody>

                <Tfoot>
                    <Tr>
                        <Th>Account ID</Th>
                        <Th>Balance</Th>
                    </Tr>
                </Tfoot>
            </Table>
            <Center>
                <div>
                    <HStack>
                        <label>Account ID</label>
                        <input type={'number'}></input>
                    </HStack>
                    <HStack>
                        <label>Password</label>
                        <input type={'password'}></input>
                    </HStack>
                    <HStack>
                        <label>Balance</label>
                        <input type={'number'}></input>
                    </HStack>
                    <Button colorScheme={'facebook'}>Create Account</Button>
                    <Button colorScheme={'red'}>Delete Account</Button>
                </div>
            </Center>
        </Box>

    )
}