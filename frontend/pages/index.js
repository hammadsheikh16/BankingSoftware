import Head from 'next/head'
import Image from 'next/image'
import {AlertDialogCloseButton, Button, Center, HStack, Text, useDisclosure, VStack} from "@chakra-ui/react";
import {
    AlertDialog,
    AlertDialogBody,
    AlertDialogFooter,
    AlertDialogHeader,
    AlertDialogContent,
    AlertDialogOverlay,
} from '@chakra-ui/react'
import React, {useState} from "react";


export default function Home() {
    const { isOpen: isOpenCustomer, onOpen: onOpenCustomer, onClose: onCloseCustomer } = useDisclosure()
    const { isOpen: isEmployeeOpen, onOpen: onOpenEmployee, onClose: onCloseEmployee } = useDisclosure()
    const { isOpen: isOpenManager, onOpen: onOpenManager, onClose: onCloseManager } = useDisclosure()
    const cancelRef = React.useRef()

    function updateInput(e){

    }
  return (
      <>
          <Center pt={10}>
              <VStack borderRadius={'2xl'} w={'50vw'} className={'glass'} padding={10}>
                  <Text alignSelf={'center'}>{"Welcome to Hammad's mock bank!"}</Text>

                  <Button colorScheme='blue' onClick={onOpenCustomer}>
                      Customer Login
                  </Button>

                  <AlertDialog
                      isOpen={isOpenCustomer}
                      leastDestructiveRef={cancelRef}
                      onClose={onCloseCustomer}
                  >
                      <AlertDialogOverlay>
                          <AlertDialogContent>
                              <AlertDialogHeader fontSize='lg' fontWeight='bold'>
                                  Login
                              </AlertDialogHeader>

                              <AlertDialogBody>
                                  <VStack>

                                      <HStack>

                                          <label>Account ID</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>
                                      <HStack>

                                          <label>Account Username</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>
                                      <HStack>

                                          <label>Account Password</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>

                                  </VStack>
                              </AlertDialogBody>

                              <AlertDialogFooter>
                                  <Button ref={cancelRef} onClick={onCloseCustomer}>
                                      Cancel
                                  </Button>
                                  <Button colorScheme='red' onClick={onCloseCustomer} ml={3}>
                                      Login
                                  </Button>
                                  {/*    THIS COMPONENT NEEDS TO CALL AUTH API AND REDIRECT*/}
                              </AlertDialogFooter>
                          </AlertDialogContent>
                      </AlertDialogOverlay>
                  </AlertDialog>

                  <Button onClick={onOpenEmployee} colorScheme={'green'}>Employee Login</Button>
                  <AlertDialog
                      isOpen={isEmployeeOpen}
                      leastDestructiveRef={cancelRef}
                      onClose={onCloseEmployee}
                  >
                      <AlertDialogOverlay>
                          <AlertDialogContent>
                              <AlertDialogHeader fontSize='lg' fontWeight='bold'>
                                  Login
                              </AlertDialogHeader>

                              <AlertDialogBody>
                                  <VStack>

                                      <HStack>

                                          <label>Account ID</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>
                                      <HStack>

                                          <label>Account Username</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>
                                      <HStack>

                                          <label>Account Password</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>

                                  </VStack>
                              </AlertDialogBody>

                              <AlertDialogFooter>
                                  <Button ref={cancelRef} onClick={onCloseEmployee}>
                                      Cancel
                                  </Button>
                                  <Button colorScheme='red' onClick={onCloseEmployee} ml={3}>
                                      Login
                                  </Button>
                                  {/*    THIS COMPONENT NEEDS TO CALL AUTH API AND REDIRECT*/}
                              </AlertDialogFooter>
                          </AlertDialogContent>
                      </AlertDialogOverlay>
                  </AlertDialog>

                  <Button onClick={onOpenManager} colorScheme={'red'}>Manager Login</Button>
                  <AlertDialog
                      isOpen={isOpenManager}
                      leastDestructiveRef={cancelRef}
                      onClose={onCloseManager}
                  >
                      <AlertDialogOverlay>
                          <AlertDialogContent>
                              <AlertDialogHeader fontSize='lg' fontWeight='bold'>
                                  Login
                              </AlertDialogHeader>

                              <AlertDialogBody>
                                  <VStack>

                                      <HStack>

                                          <label>Username</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>
                                      <HStack>

                                          <label>Password</label>
                                          <input type={'text'} style={{background: "lightskyblue"}}></input>

                                      </HStack>

                                  </VStack>
                              </AlertDialogBody>

                              <AlertDialogFooter>
                                  <Button ref={cancelRef} onClick={onCloseManager}>
                                      Cancel
                                  </Button>
                                  <Button colorScheme='red' onClick={onCloseManager} ml={3}>
                                      Login
                                  </Button>
                                  {/*    THIS COMPONENT NEEDS TO CALL AUTH API AND REDIRECT*/}
                              </AlertDialogFooter>
                          </AlertDialogContent>
                      </AlertDialogOverlay>
                  </AlertDialog>
              </VStack>
          </Center>
      </>
  )
}
